package com.malise.app.bean;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import com.malise.app.model.entity.Ward;

@Stateless
@Remote
public class WardBean extends GenericBean<Ward> implements WardBeanI {

}
