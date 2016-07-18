package com.altr.core.system.view;


import com.altr.core.Model.CategoryTable;
import com.altr.core.Model.ProductTable;
import com.altr.core.web.model.json.PageContext;

import java.util.List;

public interface CommonPage {
    public void pageLoad(Integer categoryId, PageContext pageContext) throws Exception;
}
