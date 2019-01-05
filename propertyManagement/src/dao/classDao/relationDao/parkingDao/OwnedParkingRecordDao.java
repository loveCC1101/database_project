package dao.classDao.relationDao.parkingDao;

import dao.JDBCUtil;
import dao.daoInterface.JdbcDaoImpl;
import model.relation.parking.LeasedParkingRecord;
import model.relation.parking.OwnedParkingRecord;

import java.sql.Connection;
import java.util.List;

/**
 * Created by MoonBird on 2019/1/4.
 */
public class OwnedParkingRecordDao extends JdbcDaoImpl<OwnedParkingRecord> {
    private static Connection connection = JDBCUtil.getConnection();

    public OwnedParkingRecordDao(){
        init();
    }

    public boolean addRecord(OwnedParkingRecord record){
        if (getRecordBySpaceId(record.getParking_space_id()) != null) return false;
        String sql = "INSERT INTO owned_parking_record (parking_space_id, resident_id, date, cost)" +
                " value (?, ?, ?, ?)";
        return update(connection, sql, record.getParking_space_id(),record.getResident_id(), record.getDate(), record.getCost()) != 0;
    }

    public OwnedParkingRecord getRecordBySpaceId(int parkingSpaceId){
        String sql = "SELECT * FROM owned_parking_record where parking_space_id = ?";
        return get(connection, sql, parkingSpaceId);
    }

    public List<OwnedParkingRecord> getRecordByResidentId(int residentId){
        String sql = "SELECT * FROM owned_parking_record where resident_id = ?";
        return getList(connection, sql, residentId);
    }

    public List<OwnedParkingRecord> getAll(){
        String sql = "SELECT * FROM owned_parking_record ";
        return getList(connection, sql);
    }

    private static void init(){

    }
}
