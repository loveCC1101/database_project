package service;

import dao.classDao.relationDao.ProperMonthRecordDao;
import dao.classDao.relationDao.PropertyRecordDao;
import dao.classDao.relationDao.equipmentDao.InEquipRepairDao;
import dao.classDao.relationDao.equipmentDao.OutEquipRepairDao;
import dao.classDao.relationDao.parkingDao.TemporaryParkingRecordDao;
import dao.classDao.relationDao.residentDao.ResidentCostDao;
import model.relation.parking.TemporaryParkingRecord;

import java.util.List;

/**
 * Created by your dad on 2019/1/5.
 */
public class PaymentService {
    TemporaryParkingRecordDao temporaryParkingRecordDao;
    ResidentCostDao      residentCostDao;
    InEquipRepairDao    indoorEquipRepairDao;
    OutEquipRepairDao   outEquipRepairDao;
    PropertyRecordDao    propertyRecordDao;
    ProperMonthRecordDao properMonthRecordDao;
    public PaymentService(){
        temporaryParkingRecordDao = new TemporaryParkingRecordDao();
        residentCostDao =new ResidentCostDao();
        indoorEquipRepairDao = new InEquipRepairDao();
        outEquipRepairDao=new OutEquipRepairDao();
        propertyRecordDao = new PropertyRecordDao();
        properMonthRecordDao=new ProperMonthRecordDao();
    }
    //用户付款状态调整
    public boolean pay(int costId){
        return residentCostDao.modifyState(costId, 0);
    }

    public List<TemporaryParkingRecord> getTemParkingRecordCost(){

    }

}
