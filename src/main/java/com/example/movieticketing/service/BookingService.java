package com.example.movieticketing.service;

import com.example.movieticketing.dto.*;
import com.example.movieticketing.entity.BookingDetails;
import com.example.movieticketing.entity.Shows;
import com.example.movieticketing.entity.UserDetails;
import com.example.movieticketing.entity.UserSession;
import com.example.movieticketing.repository.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class BookingService {

    @Autowired
    ShowsSearchRepository showsSearchRepository;

    @Autowired
    ShowsRepository showsRepository;

    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    UtilityService utilityService;

    @Autowired
    SessionRepository sessionRepository;

    @Autowired
    BookingDetailsRepository bookingDetailsRepository;

    public ResponseEntity getAllShowsByRequest(ShowRequest request){
        log.info("Fetching all shows based on request ");
        List<Shows> shows = showsSearchRepository.getAllShowsBasedOnRequest(request);
        return new ResponseEntity(true, ApiResponse.LIST_FETCHED, shows);

    }

    public ResponseEntity addShows(CreateShow request){
        log.info("Adding show for {} ",request.getMovieName());
        Shows shows = new Shows(request);
        shows = showsRepository.save(shows);
        return new ResponseEntity(true, ApiResponse.ADD_SUCCESSFUL, shows);
    }

    public ResponseEntity signUp(SignUpRequest request){
        log.info("SignUp request for {} ",request.getUserEmail());
        UserDetails userDetails = new UserDetails(request);
        String password = utilityService.encode(request.getPassword());
        userDetails.setPassword(password);
        userDetails = userDetailsRepository.save(userDetails);
        UserSession session = new UserSession(userDetails.getId());
        session = sessionRepository.save(session);
        return new ResponseEntity(true,ApiResponse.SIGN_UP,session);
    }

    public ResponseEntity login(LoginRequest request){
        log.info("Login request for {} ",request.getUserEmail());
        UserDetails userDetails = userDetailsRepository.findByUserEmail(request.getUserEmail());
        Boolean validate = utilityService.decode(userDetails.getPassword()).equals(request.getPassword());
        if (validate){
            UserSession session = sessionRepository.findByUserId(userDetails.getId());
            session.setIsActive(Boolean.TRUE);
            session.setLastLoggedIn(LocalDateTime.now());
            sessionRepository.save(session);
            return new ResponseEntity(true,ApiResponse.LOGGED_IN,session);
        }
        return new ResponseEntity(false,ApiResponse.LOGIN_FAILED,null);
    }

    public ResponseEntity logout(Long sessionId){
            Optional<UserSession> session = sessionRepository.findById(sessionId);
            if(session.isPresent()) {
                session.get().setIsActive(Boolean.FALSE);
                sessionRepository.save(session.get());
                return new ResponseEntity(true, ApiResponse.LOGGED_OUT, null);
            }
        return new ResponseEntity(false,ApiResponse.SOMETHING_WENT_WRONG,null);
    }

    public ResponseEntity bookShow(BookingRequest request){
        log.info("Booking request for user {} ",request.getUserId());
        Optional<UserSession> session = sessionRepository.findById(request.getSessionId());
        if(session.isPresent()) {
            if (session.get().getIsActive()) {
                BookingDetails bookingDetails = bookingDetailsRepository.findByShowId(request.getShowId());
                if (bookingDetails != null) {
                    Integer bookedSeats = bookingDetails.getBookedSeats();
                    bookedSeats = bookedSeats + request.getRequiredSeats();
                    bookingDetails.setBookedSeats(bookedSeats);
                }
                else {
                    bookingDetails = new BookingDetails(request);
                }
                bookingDetailsRepository.save(bookingDetails);
                return new ResponseEntity(true, ApiResponse.SHOW_BOOKED, null);
            }
        }
        return new ResponseEntity(false,ApiResponse.LOGIN_REQUIRED,null);
    }

    public ResponseEntity bookingInfo(Long showId){
        log.info("Fetching booking info for show {} ",showId);
        BookingDetails bookingDetails = bookingDetailsRepository.findByShowId(showId);
        if(bookingDetails != null){
            return new ResponseEntity(true, ApiResponse.LIST_FETCHED, bookingDetails);
        }
        else {
            return new ResponseEntity(false, ApiResponse.NO_RECORDS, null);
        }
    }



}
