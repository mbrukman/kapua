/*******************************************************************************
 * Copyright (c) 2017 Eurotech and/or its affiliates and others
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Eurotech - initial API and implementation
 *
 *******************************************************************************/
package org.eclipse.kapua.app.console.shared.service;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import org.eclipse.kapua.app.console.shared.GwtKapuaException;
import org.eclipse.kapua.app.console.shared.model.GwtConfigComponent;
import org.eclipse.kapua.app.console.shared.model.GwtPermission.GwtAction;
import org.eclipse.kapua.app.console.shared.model.GwtPermission.GwtDomain;
import org.eclipse.kapua.app.console.shared.model.GwtXSRFToken;

import java.util.List;

@RemoteServiceRelativePath("domain")
public interface GwtDomainService extends RemoteService {

    /**
     * Returns the list of all Domains which belong to an account.
     *
     * @return a list of {@link org.eclipse.kapua.service.authorization.domain.Domain} objects
     * @throws GwtKapuaException
     * 
     */
    public List<GwtDomain> findAll()
        throws GwtKapuaException;
    
    /**
     * Returns the list of all Actions which belong to a Domain.
     *
     * @param domainName    the name of the domain
     * @return a list of {@link org.eclipse.kapua.service.authorization.permission.Action} objects
     * @throws GwtKapuaException
     * 
     */
    public List<GwtAction> findActionsByDomainName(String domainName)
        throws GwtKapuaException;

    /**
     * Returns the configuration of a Device as the list of all the configurable components.
     *
     * @param scopeId
     * @return
     */
    public List<GwtConfigComponent> findServiceConfigurations(String scopeId)
            throws GwtKapuaException;

    /**
     * Updates the configuration of the provided component.
     *
     * @param scopeId
     * @param configComponent
     */
    public void updateComponentConfiguration(GwtXSRFToken xsrfToken, String scopeId, GwtConfigComponent configComponent)
            throws GwtKapuaException;
}