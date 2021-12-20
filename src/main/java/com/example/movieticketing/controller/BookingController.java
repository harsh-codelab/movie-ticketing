package com.example.movieticketing.controller;

import com.example.movieticketing.dto.*;
import com.example.movieticketing.service.BookingService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Log4j2
@RestController
@RequestMapping(value = "")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @RequestMapping(value = "",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;
    }

    @RequestMapping(value = "/user/signup",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity signUp(@RequestBody SignUpRequest request) {
        try {
            return bookingService.signUp(request);
        }
        catch (Exception exception){
            log.error("Exception occurred while signup",exception);
            return new ResponseEntity(false,ApiResponse.SOMETHING_WENT_WRONG,null);
        }
    }

    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity login(@RequestBody LoginRequest request) {
        try {
            return bookingService.login(request);
        }
        catch (Exception exception){
            log.error("Exception occurred while login",exception);
            return new ResponseEntity(false,ApiResponse.SOMETHING_WENT_WRONG,null);
        }
    }

    @RequestMapping(value = "/user/logout",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity logout(@RequestParam Long sessionId) {
        try {
            return bookingService.logout(sessionId);
        }
        catch (Exception exception){
            log.error("Exception occurred while logout",exception);
            return new ResponseEntity(false,ApiResponse.SOMETHING_WENT_WRONG,null);
        }
    }

    @RequestMapping(value = "/shows/view",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity getShowsDetails(@RequestBody ShowRequest request) {
        try {
            return bookingService.getAllShowsByRequest(request);
        }
        catch (Exception exception){
            log.error("Exception occurred while listing",exception);
            return new ResponseEntity(false,ApiResponse.SOMETHING_WENT_WRONG,null);
        }
    }

    @RequestMapping(value = "/shows/add",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity addShow(@RequestBody CreateShow request) {
        try {
            return bookingService.addShows(request);
        }
        catch (Exception exception){
            log.error("Exception occurred while adding shows",exception);
            return new ResponseEntity(false,ApiResponse.SOMETHING_WENT_WRONG,null);
        }
    }

    @RequestMapping(value = "/shows/book",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity bookShow(@RequestBody BookingRequest request) {
        try {
            return bookingService.bookShow(request);
        }
        catch (Exception exception){
            log.error("Exception occurred while booking",exception);
            return new ResponseEntity(false,ApiResponse.SOMETHING_WENT_WRONG,null);
        }
    }

    @RequestMapping(value = "/shows/bookingInfo",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity bookingInfo(@RequestParam Long showId) {
        try {
            return bookingService.bookingInfo(showId);
        }
        catch (Exception exception){
            log.error("Exception occurred while fetching booking info",exception);
            return new ResponseEntity(false,ApiResponse.SOMETHING_WENT_WRONG,null);
        }
    }


}
