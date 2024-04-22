package com.comumu.hmj.chat.controller;

import com.comumu.hmj.chat.repository.ChatroomRepository;
import com.comumu.hmj.chat.repository.ChatRoomRepositorys;
import com.comumu.hmj.user.dto.UserDto;
import com.comumu.hmj.user.repository.UserRepository;
import com.comumu.hmj.user.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
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

        RestTemplate restTemplate = new RestTemplate();
        UserDto userDto = restTemplate.getForObject("http://localhost:8080/user", UserDto.class);


        rttr.addFlashAttribute("user", userDto);
        return "redirect:/chat/dm?userId=" + userId;
    }


    //채팅방 조회 ### 통째로 리팩터링 해야함 ###
    @GetMapping("/dm")
    public ModelAndView getRoom(@RequestParam Long userId, Model model, HttpServletRequest request){

        log.info("# get Chat Room, roomID : " + userId);

        String token = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("Authorization".equals(cookie.getName())) { // 원하는 쿠키 이름으로 변경
                    token = cookie.getValue(); // 원하는 쿠키의 값 반환
                    break;
                }
            }
        }

        RestTemplate restTemplate = new RestTemplateBuilder()
                .defaultHeader("Authorization", "Bearer " + token)
                .build();

        UserDto userDto = restTemplate.getForObject("http://localhost:8080/user", UserDto.class);

        ModelAndView mv = new ModelAndView("chat/dmRoom");
        mv.addObject("user", userDto);

        return mv;
    }

}
