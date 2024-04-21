package com.comumu.hmj.chat.controller;

import com.comumu.hmj.chat.repository.ChatroomRepository;
import com.comumu.hmj.chat.repository.ChatRoomRepositorys;
import com.comumu.hmj.user.repository.UserRepository;
import com.comumu.hmj.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/chat")
@Log4j2
public class RoomController {

    private final ChatRoomRepositorys repository;
    private final UserRepository userRepository;


    //채팅방 목록 조회
    @GetMapping(value = "/users")
    public ModelAndView users(){
        ModelAndView mv = new ModelAndView("chat/dmList");
        mv.addObject("list", userRepository.findAll());

        return mv;
    }

    //채팅방 목록 조회
    @GetMapping(value = "/rooms")
    public ModelAndView rooms(){
        ModelAndView mv = new ModelAndView("chat/rooms");
        mv.addObject("list", repository.findAllRooms());

        return mv;
    }

    //채팅방 개설
    @PostMapping(value = "/room")
    public String create(@RequestParam String userId, RedirectAttributes rttr){

        log.info("# Create Chat Room , name: " + userId);
//        rttr.addFlashAttribute("roomName", repository.createChatRoomDTO(userId).getName());
        return "redirect:/chat/room?roomId=" + userId;
    }

//    //채팅방 조회
//    @GetMapping("/room")
//    public void getRoom(String roomId, Model model){
//
//        log.info("# get Chat Room, roomID : " + roomId);
//
//        model.addAttribute("room", repository.findRoomById(roomId));
//    }

    //채팅방 생성
    @PostMapping("/dm")
    public String newDmRoom(@RequestParam Long userId, RedirectAttributes rttr){

        log.info("# Create Chat Room , name: " + userId);


        rttr.addFlashAttribute("roomName", userRepository.findById(userId));
        return "redirect:/chat/dm?userId=" + userId;
    }

    //채팅방 조회
    @GetMapping("/dm")
    public ModelAndView getRoom(@RequestParam Long userId, Model model){

        log.info("# get Chat Room, roomID : " + userId);

        ModelAndView mv = new ModelAndView("chat/dmRoom");

        return mv;
    }

}
