//package com.jt.domain;
//
//import com.jt.model.UserMember;
//
//import java.util.Arrays;
//import java.util.Collection;
//
///**
// * 会员详情封装
// */
//public class MemberDetails implements UserDetails {
//    private UserMember userMember;
//
//    public MemberDetails(UserMember userMember) {
//        this.userMember = userMember;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        //返回当前用户的权限
//        return Arrays.asList(new SimpleGrantedAuthority("TEST"));
//    }
//
//    @Override
//    public String getPassword() {
//        return userMember.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return userMember.getUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return userMember.getStatus()==1;
//    }
//
//    public UserMember getUserMember() {
//        return userMember;
//    }
//}
