package hzqing.com.blogadmin.admin.blogger.diary.service;

import hzqing.com.blogadmin.admin.blogger.diary.entity.Diary;
import hzqing.com.blogadmin.base.service.IBaseService;

import java.util.List;

public interface IDiaryService extends IBaseService<Diary> {
    List<Diary> showAll(Diary diary);
}
