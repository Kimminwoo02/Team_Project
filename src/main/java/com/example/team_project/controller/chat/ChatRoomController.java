package com.example.team_project.controller.chat;


import com.example.team_project.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatRoomController {
    private final ChatRoomRepository chatRoomRepository;

    //채팅방 목록 조회
    @GetMapping(value = "/rooms")
    public ModelAndView rooms(){

        ModelAndView mv = new ModelAndView("chat/rooms");

        mv.addObject("list", chatRoomRepository.findAllRooms());

        return mv;
    }

    //채팅방 개설
    @PostMapping(value = "/room")
    public String create(@RequestParam String name, RedirectAttributes rttr){

        rttr.addFlashAttribute("roomName", chatRoomRepository.createChatRoomDTO(name));
        return "redirect:/chat/rooms";
    }

    //채팅방 조회
    @GetMapping("/room")
    public ModelAndView getRoom(@RequestParam(value = "roomId") String roomId){
        ModelAndView mv = new ModelAndView("chat/room");
        mv.addObject("room", chatRoomRepository.findRoomById(roomId));
        return mv;
    }
}