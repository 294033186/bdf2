/*
 * This file is part of BDF
 * BDF,Bstek Development Framework
 * Copyright 2002-2012, BSTEK
 * Dual licensed under the Bstek Commercial or GPL Version 2 licenses.
 * http://www.bstek.com/
 */
package com.bstek.bdf2.core.orm.jdbc.dialect;

import java.sql.Connection;

/**
 * @since 2016-12-19
 * @author William.Jiang
 */
public class SQLServer2014Dialect extends SQLServer2005Dialect {

	@Override
	public boolean support(Connection connection) {
		return support(connection, "sql server", "12");
	}
}
