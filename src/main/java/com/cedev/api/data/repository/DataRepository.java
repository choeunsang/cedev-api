package com.cedev.api.data.repository;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.cedev.api.data.dto.EstateItem;
import com.cedev.api.data.dto.EstateRentItem;

@Repository
public class DataRepository {

    //-------------------------------------------------------------------------------------------
    // Declare and initialize variables
    //-------------------------------------------------------------------------------------------
    private final JdbcTemplate jdbcTemplate;

    public DataRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    //-------------------------------------------------------------------------------------------
    // 주택 매매 데이터 삭제
    //-------------------------------------------------------------------------------------------
    public void deleteHousTradData(String tableNm, String contYear) {

        //-------------------------------------------------------------------------------------------
        // Declare and initialize variables
        //-------------------------------------------------------------------------------------------
        String sql = """
            DELETE FROM %s
            WHERE ContYear = ?
        """.formatted(getSafeTableName(tableNm));

        //-------------------------------------------------------------------------------------------
        // Processing
        //-------------------------------------------------------------------------------------------
        jdbcTemplate.update(sql, contYear);
    }

    //-------------------------------------------------------------------------------------------
    // 주택 매매 신규 데이터 저장
    //-------------------------------------------------------------------------------------------
    public void insertHousTradData(String tableNm, List<EstateItem> list) {

        //-------------------------------------------------------------------------------------------
        // Declare and initialize variables
        //-------------------------------------------------------------------------------------------
        String sql = """
            INSERT INTO %s
            (
                City, Bungi, BonBun, BuBun, Dangi,
                DediArea, ContYear, ContDate, Amount, Floor,
			    ConsYear, Road, DateCancel, TransType, BrokerLoc, 
			    RegiDt, sido, sigungu, dong,
			    InsertDt
            )
			VALUES
			(?, ?, ?, ?, ?,
			 ?, ?, ?, ?, ?,
			 ?, ?, ?, ?, ?,
             ?, ?, ?, ?,
			 GETDATE())
        """.formatted(getSafeTableName(tableNm));

        //-------------------------------------------------------------------------------------------
        // Processing
        //-------------------------------------------------------------------------------------------
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i) throws java.sql.SQLException {

                EstateItem item = list.get(i);

                ps.setString(1, clean(item.getCity()));
                ps.setString(2, clean(item.getBungi()));
                ps.setString(3, clean(item.getBonBun()));
                ps.setString(4, clean(item.getBuBun()));
                ps.setString(5, clean(item.getDangi()).replace("'", ""));

                ps.setString(6, clean(item.getDediArea()));
                ps.setString(7, clean(item.getContYear()));
                ps.setString(8, clean(item.getContDate()));
                ps.setString(9, clean(item.getAmount()));
                ps.setString(10, clean(item.getFloor()));

                ps.setString(11, clean(item.getConsYear()));
                ps.setString(12, clean(item.getRoad()));
                ps.setString(13, clean(item.getDateCancel()));
                ps.setString(14, clean(item.getTransType()));
                ps.setString(15, clean(item.getBrokerLoc()));
                
                ps.setString(16, clean(item.getRegiDt()));                
                ps.setString(17, clean(item.getSido()));
                ps.setString(18, clean(item.getSigungu()));
                ps.setString(19, clean(item.getDong()));
            }

            @Override
            public int getBatchSize() {
                return list.size();
            }
        });
    }

    
    //-------------------------------------------------------------------------------------------
    // 주택 전월세 데이터 삭제
    //-------------------------------------------------------------------------------------------
    public void deleteHousRentData(String tableNm, String contYear) {

        //-------------------------------------------------------------------------------------------
        // Declare and initialize variables
        //-------------------------------------------------------------------------------------------
        String sql = """
            DELETE FROM %s
            WHERE ContYear = ?
        """.formatted(getSafeTableName(tableNm));

        //-------------------------------------------------------------------------------------------
        // Processing
        //-------------------------------------------------------------------------------------------
        jdbcTemplate.update(sql, contYear);
    }

    //-------------------------------------------------------------------------------------------
    // 주택 전월세 신규 데이터 저장
    //-------------------------------------------------------------------------------------------
    public void insertHousRentData(String tableNm, List<EstateRentItem> list) {

        //-------------------------------------------------------------------------------------------
        // Declare and initialize variables
        //-------------------------------------------------------------------------------------------
        String sql = """
            INSERT INTO %s
            (
        		City, Bungi, BonBun, BuBun, Dangi,
        		Gubun, DediArea, ContYear, ContDate, Deposit, 
        		MonPay, Floor, ConsYear, Road, Term, 
        		TermGubun, RightRequ, PrevDeposit, PrevMonPay, HousKind,			    
			    sido, sigungu, dong,
			    InsertDt			    
            )
			VALUES
			(?, ?, ?, ?, ?,
			 ?, ?, ?, ?, ?, 
			 ?, ?, ?, ?, ?,
			 ?, ?, ?, ?, ?,  
			 ?, ?, ?,        
			 GETDATE())
        """.formatted(getSafeTableName(tableNm));

        //-------------------------------------------------------------------------------------------
        // Processing
        //-------------------------------------------------------------------------------------------
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i) throws java.sql.SQLException {

            	EstateRentItem item = list.get(i);

                ps.setString(1, clean(item.getCity()));
                ps.setString(2, clean(item.getBungi()));
                ps.setString(3, clean(item.getBonBun()));
                ps.setString(4, clean(item.getBuBun()));
                ps.setString(5, clean(item.getDangi()).replace("'", ""));

                ps.setString(6, clean(item.getGubun()));                          
                ps.setString(7, clean(item.getDediArea()));
                ps.setString(8, clean(item.getContYear()));
                ps.setString(9, clean(item.getContDate()));                
                ps.setString(10, clean(item.getDeposit()));
                
                ps.setString(11, clean(item.getMonPay()));
                ps.setString(12, clean(item.getFloor()));                
                ps.setString(13, clean(item.getConsYear()));                              
                ps.setString(14, clean(item.getRoad()));                
                ps.setString(15, clean(item.getTerm()));
                
                ps.setString(16, clean(item.getTermGubun()));
                ps.setString(17, clean(item.getRightRequ()));                
                ps.setString(18, clean(item.getPrevDeposit()));                
                ps.setString(19, clean(item.getPrevMonPay()));                
                ps.setString(20, clean(item.getHouseKind())); 
                                                
                ps.setString(21, clean(item.getSido()));
                ps.setString(22, clean(item.getSigungu()));
                ps.setString(23, clean(item.getDong()));
            }

            @Override
            public int getBatchSize() {
                return list.size();
            }
        });
    }    
    
    //-------------------------------------------------------------------------------------------
    // 테이블명 검증
    //-------------------------------------------------------------------------------------------
    private String getSafeTableName(String tableNm) {

        if ("KR_REAL_INFO".equalsIgnoreCase(tableNm)) {
            return "KR_REAL_INFO";
        }
        
        if ("KR_REAL_RENT_INFO".equalsIgnoreCase(tableNm)) {
            return "KR_REAL_RENT_INFO";
        }
        

        throw new IllegalArgumentException("허용되지 않은 테이블명입니다.");
    }

    //-------------------------------------------------------------------------------------------
    // 문자열 정리
    //-------------------------------------------------------------------------------------------
    private String clean(String value) {

        if (value == null) {
            return "";
        }

        return value.replace("\"", "");
    }
}