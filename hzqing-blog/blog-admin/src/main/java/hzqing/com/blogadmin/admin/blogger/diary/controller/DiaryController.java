package hzqing.com.blogadmin.admin.blogger.diary.controller;

import hzqing.com.blogadmin.admin.blogger.diary.entity.Diary;
import hzqing.com.blogadmin.admin.blogger.diary.service.IDiaryService;
import hzqing.com.blogadmin.base.controller.BaseController;
import hzqing.com.blogadmin.utils.ResponseMessage;
import hzqing.com.hzqingcommon.util.DateUtils;
import hzqing.com.hzqingcommon.util.FileUtil;
import hzqing.com.hzqingcommon.util.UUIDUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/admin/blogger/diary")
public class DiaryController extends BaseController<Diary,IDiaryService> {

    @GetMapping("/show/all")
    public ResponseMessage<List<Diary>> showAll(Diary diary) {
        List<Diary> lists = baseService.showAll(diary);
        return new ResponseMessage<>().success(lists);
    }
}
