package com.gofar.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.gofar.domain.Category;
import com.gofar.service.CategoryService;
import com.gofar.utils.HibernateSessionFactory;

public class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {

}
