package hzqing.com.blogadmin.admin.bus.diary.controller;

import hzqing.com.blogadmin.admin.bus.diary.entity.Diary;
import hzqing.com.blogadmin.admin.bus.diary.service.IDiaryService;
import hzqing.com.blogadmin.base.controller.BaseController;
import hzqing.com.blogadmin.utils.ResponseMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bus/diary")
public class DiaryController extends BaseController<Diary,IDiaryService> {

    @GetMapping("/show/all")
    public ResponseMessage<List<Diary>> showAll(Diary diary) {
        List<Diary> lists = baseService.showAll(diary);
        return new ResponseMessage<>().success(lists);
    }
}
