package com.wangkaiyi.model;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_user")
public class User {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String username;
    private String password;
    private String gender;
    private String address;
    private Long money;
    private Long status;
    private String email;
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public User(Long id, String address) {
    }
}
