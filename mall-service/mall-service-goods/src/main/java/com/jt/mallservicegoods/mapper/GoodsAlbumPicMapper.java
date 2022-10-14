package com.jt.mallservicegoods.mapper;

import java.util.List;

import com.jt.model.GoodsAlbumPic;
import com.jt.model.GoodsAlbumPicExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsAlbumPicMapper {
    long countByExample(GoodsAlbumPicExample example);

    int deleteByExample(GoodsAlbumPicExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GoodsAlbumPic record);

    int insertSelective(GoodsAlbumPic record);

    List<GoodsAlbumPic> selectByExample(GoodsAlbumPicExample example);

    GoodsAlbumPic selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") GoodsAlbumPic record, @Param("example") GoodsAlbumPicExample example);

    int updateByExample(@Param("record") GoodsAlbumPic record, @Param("example") GoodsAlbumPicExample example);

    int updateByPrimaryKeySelective(GoodsAlbumPic record);

    int updateByPrimaryKey(GoodsAlbumPic record);
}