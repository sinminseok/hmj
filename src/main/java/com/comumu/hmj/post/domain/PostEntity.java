package com.comumu.hmj.post.domain;

import com.comumu.hmj.common.domain.BaseTimeEntity;

public abstract class PostEntity extends BaseTimeEntity {

    private String postName;

    private String postContent;

    private String address;

    private long viewCount;

}
