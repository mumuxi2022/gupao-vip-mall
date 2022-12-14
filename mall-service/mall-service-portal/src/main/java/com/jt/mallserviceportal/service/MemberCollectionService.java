package com.jt.mallserviceportal.service;

import com.jt.domain.MemberProductCollection;
import org.springframework.data.domain.Page;

/**
 * 会员收藏Service
 */
public interface MemberCollectionService {
    int add(MemberProductCollection productCollection);

    int delete(Long productId);

    Page<MemberProductCollection> list(Integer pageNum, Integer pageSize);

    MemberProductCollection detail(Long productId);

    void clear();
}
