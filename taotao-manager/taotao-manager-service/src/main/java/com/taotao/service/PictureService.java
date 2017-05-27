package com.taotao.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * Created by xy on 2017/5/27.
 */
public interface PictureService {

    Map uploadPitcture(MultipartFile uploadFile);
}
