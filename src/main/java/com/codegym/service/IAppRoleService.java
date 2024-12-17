package com.codegym.service;

import com.codegym.model.AppRole;

public interface IAppRoleService extends IGeneralService<AppRole>{
    AppRole getAppRoleByAppRoleName(String appRoleName);
}
