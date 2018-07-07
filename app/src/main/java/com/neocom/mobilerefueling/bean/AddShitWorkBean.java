package com.neocom.mobilerefueling.bean;

import java.io.Serializable;

/**
 * Created by admin on 2017/10/26.
 */

public class AddShitWorkBean implements Serializable {


//
//    openType	String	Y	openType=”add” 新增地址
//    openType=”update” 修改地址
//    id	String	N	记录Id,
//    若openType=”add”，可不填
//    userId	String	Y	用户Id
//    carCode	String	Y	车牌号
//    carryUserId	String	Y	交班人userId
//    turnUserId	String	Y	接班人userId
//    carsMileage	String	Y	车辆里程数
//    remainCarOil	String	Y	车辆剩余油量
//    remainTankOil	String	Y	油罐剩余油量
//    shiftTime	String	Y	交接时间
//    shiftAddress	String	Y	交接地点
//    remark	String	Y	备注

    /**
     * openType : add
     * userId : 917f2f6eb1ce42a5968ee3a76bcf07c9
     * carryUserId : 3f67e2778c944999a00692f493862c50
     * turnUserId : 39931489bb224746ba0d0e23d20a4ced
     * carsMileage : 123
     * remainCarOil : 100
     * remainTankOil : 200
     * shiftTime : 2017-10-24
     * shiftAddress : 10月24日新增测试6
     * remark : 123
     * <p>
     * <p>
     * {
     * "openType":"add",
     * "userId":"917f2f6eb1ce42a5968ee3a76bcf07c9",
     * "carryUserId":"3f67e2778c944999a00692f493862c50",
     * "turnUserId":"39931489bb224746ba0d0e23d20a4ced",
     * "carsMileage":"123",
     * "remainCarOil":"100",
     * "remainTankOil":"200",
     * "shiftTime":"2017-10-24",
     * "shiftAddress":"10月24日新增测试6",
     * "remark":"123"
     * }
     * carCode	String	Y	车牌号
     */

    private String openType;
    private String userId;
    private String id;
    private String carryUserId;
    private String turnUserId;
    private String carsMileage;
    //    private String remainCarOil;
    private String remainTankOil;
    private String shiftTime;
    private String shiftAddress;
    private String remark;
    private String carId;
    private String carCode;
    private String joinType;
    private String joinStatus;

    public String getJoinStatus() {
        return joinStatus;
    }

    public void setJoinStatus(String joinStatus) {
        this.joinStatus = joinStatus;
    }

    public String getJoinType() {
        return joinType;
    }

    public void setJoinType(String joinType) {
        this.joinType = joinType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getOpenType() {
        return openType;
    }

    public void setOpenType(String openType) {
        this.openType = openType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCarryUserId() {
        return carryUserId;
    }

    public void setCarryUserId(String carryUserId) {
        this.carryUserId = carryUserId;
    }

    public String getTurnUserId() {
        return turnUserId;
    }

    public void setTurnUserId(String turnUserId) {
        this.turnUserId = turnUserId;
    }

    public String getCarsMileage() {
        return carsMileage;
    }

    public void setCarsMileage(String carsMileage) {
        this.carsMileage = carsMileage;
    }

//    public String getRemainCarOil() {
//        return remainCarOil;
//    }
//
//    public void setRemainCarOil(String remainCarOil) {
//        this.remainCarOil = remainCarOil;
//    }

    public String getRemainTankOil() {
        return remainTankOil;
    }

    public void setRemainTankOil(String remainTankOil) {
        this.remainTankOil = remainTankOil;
    }

    public String getShiftTime() {
        return shiftTime;
    }

    public void setShiftTime(String shiftTime) {
        this.shiftTime = shiftTime;
    }

    public String getShiftAddress() {
        return shiftAddress;
    }

    public void setShiftAddress(String shiftAddress) {
        this.shiftAddress = shiftAddress;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "AddShitWorkBean{" +
                "openType='" + openType + '\'' +
                ", userId='" + userId + '\'' +
                ", carryUserId='" + carryUserId + '\'' +
                ", turnUserId='" + turnUserId + '\'' +
                ", carsMileage='" + carsMileage + '\'' +
                ", remainTankOil='" + remainTankOil + '\'' +
                ", shiftTime='" + shiftTime + '\'' +
                ", shiftAddress='" + shiftAddress + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
