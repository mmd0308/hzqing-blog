package hzqing.com.blogadmin.admin.bus.diary.service.impl;

import hzqing.com.blogadmin.admin.bus.diary.entity.Diary;
import hzqing.com.blogadmin.admin.bus.diary.service.IDiaryService;
import hzqing.com.blogadmin.base.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryServiceImpl extends BaseServiceImpl<Diary> implements IDiaryService {
    public DiaryServiceImpl() {
        super.mapper="DiaryMapper";
    }

    @Override
    public List<Diary> showAll(Diary diary) {
        return (List<Diary>) baseDao.findForList(mapper+".showAll",diary);
    }
}
