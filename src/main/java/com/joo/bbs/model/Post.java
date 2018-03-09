package com.joo.bbs.model;

import org.springframework.web.multipart.MultipartFile;

public class Post {
    private String title;
    private String mainText;
    private int postNum;
    private String name;
    private String createDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMainText() {
        return mainText;
    }

    public void setMainText(String mainText) {
        this.mainText = mainText;
    }

    public int getPostNum() {
        return postNum;
    }

    public void setPostNum(int postNum) {
        this.postNum = postNum;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", mainText='" + mainText + '\'' +
                ", postNum=" + postNum +
                ", name='" + name + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}

