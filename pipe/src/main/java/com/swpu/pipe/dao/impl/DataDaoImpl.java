package com.swpu.pipe.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.swpu.pipe.beans.PageBean;
import com.swpu.pipe.dao.DataDao;
import com.swpu.pipe.dto.QueryData;
import com.swpu.pipe.entity.InputData;
import com.swpu.pipe.entity.ResultData;
import com.swpu.pipe.entity.User;

@Repository
public class DataDaoImpl implements DataDao{


	@Autowired
	private SessionFactory SessionFactory;
	@Override
	public Integer save(InputData entity) {
		return (Integer) SessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public boolean delete(InputData entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteById(Integer k) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(InputData entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Integer findById(Integer k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InputData> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(InputData entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PageBean<InputData> findAll(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ResultData> ansysData(QueryData queryData, String index) {
		if (index.equals("1")) {
			List<InputData> inputDatas = SessionFactory.getCurrentSession().createQuery(" from InputData i where i.externalDiameter=:externalDiameter and "
					+ "i.innerDiameter=:innerDiameter and i.elasticityModulus=:elasticityModulus and i.poissonRatio=:poissonRatio and i.typeOfCrack=:typeOfCrack and "
					+ "i.crackLength=:crackLength and i.relativeLength=:relativeLength and i.pressure=:pressure and i.yield=:yield and i.yieldOffset=:yieldOffset and i.hardening=:hardening and "
					+ "i.depthOfSubside=:depthOfSubside and i.buriedDepth=:buriedDepth and i.typeOfSoil=:typeOfSoil")
					.setParameter("externalDiameter", queryData.getExternalDiameter())
			        .setParameter("innerDiameter", queryData.getInnerDiameter()).setParameter("elasticityModulus", queryData.getElasticityModulus())
			        .setParameter("poissonRatio", queryData.getPoissonRatio()).setParameter("typeOfCrack", queryData.getTypeOfCrack())
			        .setParameter("crackLength", queryData.getCrackLength()).setParameter("relativeLength",queryData.getRelativeLength())
			        .setParameter("pressure", queryData.getPressure())
			        .setParameter("yield", queryData.getYield()).setParameter("yieldOffset", queryData.getYieldOffset()).setParameter("hardening", queryData.getHardening())
			        .setParameter("depthOfSubside", queryData.getLenghtOfSubside())
			        .setParameter("buriedDepth", queryData.getBuriedDepth())
			        .setParameter("typeOfSoil", queryData.getTypeOfSoil()).getResultList();
			List<ResultData> resultDatas = new ArrayList<>();
			for (int i = 0; i < inputDatas.size(); i++) {
				ResultData resultData = (ResultData) SessionFactory.getCurrentSession().createQuery("from ResultData r where r.inputData=:inputData")
						.setParameter("inputData", inputDatas.get(i)).uniqueResult();
				resultDatas.add(resultData);
			}
			return resultDatas;
		}
		if (index.equals("3")) {
			List<InputData> inputDatas = SessionFactory.getCurrentSession().createQuery(" from InputData i where i.externalDiameter=:externalDiameter and "
					+ "i.innerDiameter=:innerDiameter and i.elasticityModulus=:elasticityModulus and i.poissonRatio=:poissonRatio and i.typeOfCrack=:typeOfCrack and "
					+ "i.crackLength=:crackLength and i.relativeLength=:relativeLength and i.pressure=:pressure and i.yield=:yield and i.yieldOffset=:yieldOffset and i.hardening=:hardening and "
					+ "i.lenghtOfSubside=:lenghtOfSubside and i.depthOfSubside=:depthOfSubside and i.buriedDepth=:buriedDepth")
					.setParameter("externalDiameter", queryData.getExternalDiameter())
			        .setParameter("innerDiameter", queryData.getInnerDiameter()).setParameter("elasticityModulus", queryData.getElasticityModulus())
			        .setParameter("poissonRatio", queryData.getPoissonRatio()).setParameter("typeOfCrack", queryData.getTypeOfCrack())
			        .setParameter("crackLength", queryData.getCrackLength()).setParameter("relativeLength",queryData.getRelativeLength())
			        .setParameter("pressure", queryData.getPressure())
			        .setParameter("yield", queryData.getYield()).setParameter("yieldOffset", queryData.getYieldOffset()).setParameter("hardening", queryData.getHardening())
			        .setParameter("lenghtOfSubside", queryData.getLenghtOfSubside()).setParameter("depthOfSubside", queryData.getDepthOfSubside())
			        .setParameter("buriedDepth", queryData.getBuriedDepth()).getResultList();
			List<ResultData> resultDatas = new ArrayList<>();
			for (int i = 0; i < inputDatas.size(); i++) {
				ResultData resultData = (ResultData) SessionFactory.getCurrentSession().createQuery("from ResultData r where r.inputData=:inputData")
						.setParameter("inputData", inputDatas.get(i)).uniqueResult();
				resultDatas.add(resultData);
			}
			return resultDatas;			
		}
		if (index.equals("2")) {
			List<InputData> inputDatas = SessionFactory.getCurrentSession().createQuery(" from InputData i where i.externalDiameter=:externalDiameter and "
					+ "i.innerDiameter=:innerDiameter and i.elasticityModulus=:elasticityModulus and i.poissonRatio=:poissonRatio and i.typeOfCrack=:typeOfCrack and "
					+ "i.crackLength=:crackLength and i.relativeLength=:relativeLength and i.pressure=:pressure and i.yield=:yield and i.yieldOffset=:yieldOffset and i.hardening=:hardening and "
					+ "i.lenghtOfSubside=:lenghtOfSubside and i.buriedDepth=:buriedDepth and i.typeOfSoil=:typeOfSoil")
					.setParameter("externalDiameter", queryData.getExternalDiameter())
			        .setParameter("innerDiameter", queryData.getInnerDiameter()).setParameter("elasticityModulus", queryData.getElasticityModulus())
			        .setParameter("poissonRatio", queryData.getPoissonRatio()).setParameter("typeOfCrack", queryData.getTypeOfCrack())
			        .setParameter("crackLength", queryData.getCrackLength()).setParameter("relativeLength",queryData.getRelativeLength())
			        .setParameter("pressure", queryData.getPressure())
			        .setParameter("yield", queryData.getYield()).setParameter("yieldOffset", queryData.getYieldOffset()).setParameter("hardening", queryData.getHardening())
			        .setParameter("lenghtOfSubside", queryData.getLenghtOfSubside())
			        .setParameter("buriedDepth", queryData.getBuriedDepth())
			        .setParameter("typeOfSoil", queryData.getTypeOfSoil()).getResultList();
			List<ResultData> resultDatas = new ArrayList<>();
			for (int i = 0; i < inputDatas.size(); i++) {
				ResultData resultData = (ResultData) SessionFactory.getCurrentSession().createQuery("from ResultData r where r.inputData=:inputData")
						.setParameter("inputData", inputDatas.get(i)).uniqueResult();
				resultDatas.add(resultData);
			}
			return resultDatas;	
		}
		if (index.equals("4")) {
			List<InputData> inputDatas = SessionFactory.getCurrentSession().createQuery(" from InputData i where i.externalDiameter=:externalDiameter and "
					+ "i.innerDiameter=:innerDiameter and i.elasticityModulus=:elasticityModulus and i.poissonRatio=:poissonRatio and i.typeOfCrack=:typeOfCrack and "
					+ "i.crackLength=:crackLength and i.relativeLength=:relativeLength and i.pressure=:pressure and i.yield=:yield and i.yieldOffset=:yieldOffset and i.hardening=:hardening and "
					+ "i.lenghtOfSubside=:lenghtOfSubside and i.depthOfSubside=:depthOfSubside and i.typeOfSoil=:typeOfSoil")
					.setParameter("externalDiameter", queryData.getExternalDiameter())
			        .setParameter("innerDiameter", queryData.getInnerDiameter()).setParameter("elasticityModulus", queryData.getElasticityModulus())
			        .setParameter("poissonRatio", queryData.getPoissonRatio()).setParameter("typeOfCrack", queryData.getTypeOfCrack())
			        .setParameter("crackLength", queryData.getCrackLength()).setParameter("relativeLength",queryData.getRelativeLength())
			        .setParameter("pressure", queryData.getPressure())
			        .setParameter("yield", queryData.getYield()).setParameter("yieldOffset", queryData.getYieldOffset()).setParameter("hardening", queryData.getHardening())
			        .setParameter("lenghtOfSubside", queryData.getLenghtOfSubside())
			        .setParameter("depthOfSubside", queryData.getDepthOfSubside())
			        .setParameter("typeOfSoil", queryData.getTypeOfSoil()).getResultList();
			List<ResultData> resultDatas = new ArrayList<>();
			for (int i = 0; i < inputDatas.size(); i++) {
				ResultData resultData = (ResultData) SessionFactory.getCurrentSession().createQuery("from ResultData r where r.inputData=:inputData")
						.setParameter("inputData", inputDatas.get(i)).uniqueResult();
				resultDatas.add(resultData);
			}
			return resultDatas;				
		}
		if (index.equals("5")) {
			List<InputData> inputDatas = SessionFactory.getCurrentSession().createQuery(" from InputData i where i.externalDiameter=:externalDiameter and "
					+ "i.innerDiameter=:innerDiameter and i.elasticityModulus=:elasticityModulus and i.poissonRatio=:poissonRatio and i.typeOfCrack=:typeOfCrack and "
					+ "i.relativeLength=:relativeLength and i.pressure=:pressure and i.yield=:yield and i.yieldOffset=:yieldOffset and i.hardening=:hardening and "
					+ "i.lenghtOfSubside=:lenghtOfSubside and i.depthOfSubside=:depthOfSubside and i.buriedDepth=:buriedDepth and i.typeOfSoil=:typeOfSoil")
					.setParameter("externalDiameter", queryData.getExternalDiameter())
			        .setParameter("innerDiameter", queryData.getInnerDiameter()).setParameter("elasticityModulus", queryData.getElasticityModulus())
			        .setParameter("poissonRatio", queryData.getPoissonRatio()).setParameter("typeOfCrack", queryData.getTypeOfCrack())
			        .setParameter("relativeLength",queryData.getRelativeLength())
			        .setParameter("pressure", queryData.getPressure())
			        .setParameter("yield", queryData.getYield()).setParameter("yieldOffset", queryData.getYieldOffset()).setParameter("hardening", queryData.getHardening())
			        .setParameter("lenghtOfSubside", queryData.getLenghtOfSubside())
			        .setParameter("depthOfSubside", queryData.getDepthOfSubside()).setParameter("buriedDepth", queryData.getBuriedDepth())
			        .setParameter("typeOfSoil", queryData.getTypeOfSoil()).getResultList();
			List<ResultData> resultDatas = new ArrayList<>();
			for (int i = 0; i < inputDatas.size(); i++) {
				ResultData resultData = (ResultData) SessionFactory.getCurrentSession().createQuery("from ResultData r where r.inputData=:inputData")
						.setParameter("inputData", inputDatas.get(i)).uniqueResult();
				resultDatas.add(resultData);
			}
			return resultDatas;				
		}
		if (index.equals("6")) {
			List<InputData> inputDatas = SessionFactory.getCurrentSession().createQuery(" from InputData i where i.externalDiameter=:externalDiameter and "
					+ "i.innerDiameter=:innerDiameter and i.elasticityModulus=:elasticityModulus and i.poissonRatio=:poissonRatio and i.typeOfCrack=:typeOfCrack and "
					+ "i.crackLength=:crackLength and i.pressure=:pressure and i.yield=:yield and i.yieldOffset=:yieldOffset and i.hardening=:hardening and "
					+ "i.lenghtOfSubside=:lenghtOfSubside and i.depthOfSubside=:depthOfSubside and i.buriedDepth=:buriedDepth and i.typeOfSoil=:typeOfSoil")
					.setParameter("externalDiameter", queryData.getExternalDiameter())
			        .setParameter("innerDiameter", queryData.getInnerDiameter()).setParameter("elasticityModulus", queryData.getElasticityModulus())
			        .setParameter("poissonRatio", queryData.getPoissonRatio()).setParameter("typeOfCrack", queryData.getTypeOfCrack())
			        .setParameter("crackLength",queryData.getCrackLength())
			        .setParameter("pressure", queryData.getPressure())
			        .setParameter("yield", queryData.getYield()).setParameter("yieldOffset", queryData.getYieldOffset()).setParameter("hardening", queryData.getHardening())
			        .setParameter("lenghtOfSubside", queryData.getLenghtOfSubside())
			        .setParameter("depthOfSubside", queryData.getDepthOfSubside()).setParameter("buriedDepth", queryData.getBuriedDepth())
			        .setParameter("typeOfSoil", queryData.getTypeOfSoil()).getResultList();
			List<ResultData> resultDatas = new ArrayList<>();
			for (int i = 0; i < inputDatas.size(); i++) {
				ResultData resultData = (ResultData) SessionFactory.getCurrentSession().createQuery("from ResultData r where r.inputData=:inputData")
						.setParameter("inputData", inputDatas.get(i)).uniqueResult();
				resultDatas.add(resultData);
			}
			return resultDatas;				
		}
		else {
			List<InputData> inputDatas = SessionFactory.getCurrentSession().createQuery(" from InputData i where i.externalDiameter=:externalDiameter and "
					+ "i.innerDiameter=:innerDiameter and i.elasticityModulus=:elasticityModulus and i.poissonRatio=:poissonRatio and i.typeOfCrack=:typeOfCrack and "
					+ "i.crackLength=:crackLength and i.relativeLength=:relativeLength and i.pressure=:pressure and i.yield=:yield and i.yieldOffset=:yieldOffset and i.hardening=:hardening and "
					+ "i.lenghtOfSubside=:lenghtOfSubside and i.buriedDepth=:buriedDepth and i.typeOfSoil=:typeOfSoil")
					.setParameter("externalDiameter", queryData.getExternalDiameter())
			        .setParameter("innerDiameter", queryData.getInnerDiameter()).setParameter("elasticityModulus", queryData.getElasticityModulus())
			        .setParameter("poissonRatio", queryData.getPoissonRatio()).setParameter("typeOfCrack", queryData.getTypeOfCrack())
			        .setParameter("crackLength", queryData.getCrackLength()).setParameter("relativeLength",queryData.getRelativeLength())
			        .setParameter("pressure", queryData.getPressure())
			        .setParameter("yield", queryData.getYield()).setParameter("yieldOffset", queryData.getYieldOffset()).setParameter("hardening", queryData.getHardening())
			        .setParameter("lenghtOfSubside", queryData.getLenghtOfSubside())
			        .setParameter("buriedDepth", queryData.getBuriedDepth())
			        .setParameter("typeOfSoil", queryData.getTypeOfSoil()).getResultList();
			List<ResultData> resultDatas = new ArrayList<>();
			for (int i = 0; i < inputDatas.size(); i++) {
				ResultData resultData = (ResultData) SessionFactory.getCurrentSession().createQuery("from ResultData r where r.inputData=:inputData")
						.setParameter("inputData", inputDatas.get(i)).uniqueResult();
				resultDatas.add(resultData);
			}
			return resultDatas;			
		}
	}
	/**
	 * 查询数据的DAO 
	 */
	@Override
	public ResultData queryResultData(QueryData queryData) {
//		Integer id = (Integer) SessionFactory.getCurrentSession().createQuery("select inputDataId from InputData i where i.externalDiameter=:externalDiameter and "
//				+ "i.innerDiameter=:innerDiameter and i.elasticityModulus=:elasticityModulus and i.poissonRatio=:poissonRatio and i.typeOfCrack=:typeOfCrack and "
//				+ "i.crackLength=:crackLength and i.relativeLength=:relativeLength and i.pressure=:pressure and i.yield=:yield and i.yieldOffset=:yieldOffset and i.hardening=:hardening and "
//				+ "i.lenghtOfSubside=:lenghtOfSubside and i.depthOfSubside=:depthOfSubside and i.buriedDepth=:buriedDepth and i.typeOfSoil=:typeOfSoil")
//				.setParameter("externalDiameter", queryData.getExternalDiameter())
//		        .setParameter("innerDiameter", queryData.getInnerDiameter()).setParameter("elasticityModulus", queryData.getElasticityModulus())
//		        .setParameter("poissonRatio", queryData.getPoissonRatio()).setParameter("typeOfCrack", queryData.getTypeOfCrack())
//		        .setParameter("crackLength", queryData.getCrackLength()).setParameter("relativeLength",queryData.getRelativeLength())
//		        .setParameter("pressure", queryData.getPressure())
//		        .setParameter("yield", queryData.getYield()).setParameter("yieldOffset", queryData.getYieldOffset()).setParameter("hardening", queryData.getHardening())
//		        .setParameter("lenghtOfSubside", queryData.getLenghtOfSubside()).setParameter("depthOfSubside", queryData.getDepthOfSubside())
//		        .setParameter("buriedDepth", queryData.getBuriedDepth())
//		        .setParameter("typeOfSoil", queryData.getTypeOfSoil()).uniqueResult();
		InputData inputData = (InputData) SessionFactory.getCurrentSession().createQuery(" from InputData i where i.externalDiameter=:externalDiameter and "
				+ "i.innerDiameter=:innerDiameter and i.elasticityModulus=:elasticityModulus and i.poissonRatio=:poissonRatio and i.typeOfCrack=:typeOfCrack and "
				+ "i.crackLength=:crackLength and i.relativeLength=:relativeLength and i.pressure=:pressure and i.yield=:yield and i.yieldOffset=:yieldOffset and i.hardening=:hardening and "
				+ "i.lenghtOfSubside=:lenghtOfSubside and i.depthOfSubside=:depthOfSubside and i.buriedDepth=:buriedDepth and i.typeOfSoil=:typeOfSoil")
				.setParameter("externalDiameter", queryData.getExternalDiameter())
		        .setParameter("innerDiameter", queryData.getInnerDiameter()).setParameter("elasticityModulus", queryData.getElasticityModulus())
		        .setParameter("poissonRatio", queryData.getPoissonRatio()).setParameter("typeOfCrack", queryData.getTypeOfCrack())
		        .setParameter("crackLength", queryData.getCrackLength()).setParameter("relativeLength",queryData.getRelativeLength())
		        .setParameter("pressure", queryData.getPressure())
		        .setParameter("yield", queryData.getYield()).setParameter("yieldOffset", queryData.getYieldOffset()).setParameter("hardening", queryData.getHardening())
		        .setParameter("lenghtOfSubside", queryData.getLenghtOfSubside()).setParameter("depthOfSubside", queryData.getDepthOfSubside())
		        .setParameter("buriedDepth", queryData.getBuriedDepth())
		        .setParameter("typeOfSoil", queryData.getTypeOfSoil()).uniqueResult();
		
		ResultData resultData = (ResultData) SessionFactory.getCurrentSession().createQuery("from ResultData r where r.inputData=:inputData")
				.setParameter("inputData", inputData).uniqueResult();
		return resultData;
	}

	@Override
	public Integer save(ResultData entity) {
		// TODO Auto-generated method stub
		return (Integer) SessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public ResultData showNewResultData() {
		Integer id =  ((Integer) SessionFactory.getCurrentSession().createQuery("SELECT MAX(resultDataId) from ResultData").uniqueResult()).intValue();
		ResultData resultData =	(ResultData) SessionFactory.getCurrentSession().createQuery("from ResultData R where R.resultDataId=:resultDataId")
				.setParameter("resultDataId", id).uniqueResult();
		return resultData;
	}



}




