package com.shirodemo.kay.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shirodemo.kay.entity.Task;
import com.shirodemo.kay.service.TaskService;
import com.shirodemo.kay.mapper.TaskMapper;
import org.springframework.stereotype.Service;

/**
* @author kay
* @description 针对表【sys_task(平台_定时任务)】的数据库操作Service实现
* @createDate 2022-05-25 20:11:20
*/
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task>
    implements TaskService{

}




