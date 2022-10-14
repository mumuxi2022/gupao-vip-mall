package com.jt.mallservicegoods.mapper;

import java.util.List;

import com.jt.model.GoodsAlbum;
import com.jt.model.GoodsAlbumExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsAlbumMapper {
    long countByExample(GoodsAlbumExample example);

    int deleteByExample(GoodsAlbumExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsAlbum record);

    int insertSelective(GoodsAlbum record);

    List<GoodsAlbum> selectByExample(GoodsAlbumExample example);

    GoodsAlbum selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsAlbum record, @Param("example") GoodsAlbumExample example);

    int updateByExample(@Param("record") GoodsAlbum record, @Param("example") GoodsAlbumExample example);

    int updateByPrimaryKeySelective(GoodsAlbum record);

    int updateByPrimaryKey(GoodsAlbum record);
}