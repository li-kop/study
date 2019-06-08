package com.ljq.mvc.dto;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

/**
 * @author : LJQ
 * @date : 2019/6/6 18:19
 */
@Data
public class User {

    public interface SimpleView {
    }

    public interface DetailView extends SimpleView {
    }

    @JsonView(SimpleView.class)
    private String userName;

    @JsonView(DetailView.class)
    private String password;

}
