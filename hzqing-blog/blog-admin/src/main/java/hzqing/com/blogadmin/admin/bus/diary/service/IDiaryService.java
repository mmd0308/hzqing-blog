package hzqing.com.blogadmin.admin.bus.diary.service;

import hzqing.com.blogadmin.admin.bus.diary.entity.Diary;
import hzqing.com.blogadmin.base.service.IBaseService;

import java.util.List;

public interface IDiaryService extends IBaseService<Diary> {
    List<Diary> showAll(Diary diary);
}
