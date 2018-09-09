package com.skyhospital.dao;

import com.skyhospital.pojo.Dosageforms;
import com.skyhospital.pojo.Warehouse;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface WarehouseMapper {

    /**
     * 根据出入库详情去修改库存信息
     * @param warehouse
     * @return
     */
    int modifyWarehouse(Warehouse warehouse);


    /**
     * 如果出入库信息审核通过了就要进行库存查找，如果没有数据就要添加
     * @param warehouse
     * @return
     */
    int addWarehouse(Warehouse warehouse);


    /**
     * 显示药品处理记录
     * 来自UC0207
     * @param map
     * @return
     */
    /**/
    List<Warehouse> getDisposeMedicineList(Map<String ,Object> map);

    /**
     * 获取药品处理记录总条数
     * 来自UC0207
     * @param map
     * @return
     */
    /**/
    int getDisposeMedicineCount(Map<String ,Object> map);

    /**
     * 有效期报警，显示距离有效期两个月的药品信息
     * 来自UC0206
     * @param map
     * @return
     */
    /**/
    List<Warehouse> getListByValidity(Map<String ,Object> map);

    /**
     * 获取有效期报警药品总条数
     * 来自UC0206
     * @return
     */
    /**/
    int getCountByValidity(Map<String ,Object> map);


    /**
     * 调价
     * 来自UC0205
     * @param item
     * @param discount
     * @return
     */
    int modifyMedicinePrice(@Param("item")Integer [] item,@Param("discount")double discount);


    /**
     * 根据条件(药品名，库存量多/少，距有效期两个月)获取调价药品信息
     * 来自UC0205
     * @param map   传药品名，库存量，有效期，当前页，页码
     * @return
     */
    /**/
    List<Warehouse> getAdjustPriceMedicineByCondition(Map<String,Object> map);

    /**
     * 获取调价药品总条数
     * 来自UC0205
     * @return
     */
    /**/
    int getCountByAPMedicine(Map<String,Object> map);

    /**
     * 根据id查询药品信息
     * 来自UC0204，UC0207
     * @param medicineId    药品编号
     * @return
     */
    /**/
    Warehouse getMedicineMsgById(@Param("medicineId")Integer medicineId);


    /**
     * 获取所有剂型
     * @return
     */
    List<Dosageforms> getAllDos();


    /**
     * 修改药品库存信息
     * 注意，只可以修改数量
     * 来自UC0204，UC0207
     * @param number    数量
     * @param medicineId    药品id
     * @return
     */
    /**/
    int modifyMedicineMessage(@Param("number")Integer number, @Param("medicineId")Integer medicineId);

    /**
     * 获取库存盘点信息列表
     * 来自UC0204
     * @param map
     * @return
     */
    /**/
    List<Warehouse> getInventoryList(Map<String,Object> map);

    /**
     * 获取库存信息总条数
     * 来自UC0204
     * @param map
     * @return
     */
    /**/
    int getCountByInventory(Map<String,Object> map);

}