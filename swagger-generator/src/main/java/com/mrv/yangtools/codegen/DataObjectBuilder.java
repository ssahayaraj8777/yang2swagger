/*
 * Copyright (c) 2016 MRV Communications, Inc. All rights reserved.
 *  This program and the accompanying materials are made available under the
 *  terms of the Eclipse Public License v1.0 which accompanies this distribution,
 *  and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 *  Contributors:
 *      Christopher Murch <cmurch@mrv.com>
 *      Bartosz Michalik <bartosz.michalik@amartus.com>
 */

package com.mrv.yangtools.codegen;

import io.swagger.models.Model;
import io.swagger.models.Swagger;
import org.opendaylight.yangtools.yang.model.api.DataNodeContainer;
import org.opendaylight.yangtools.yang.model.api.Module;
import org.opendaylight.yangtools.yang.model.api.SchemaNode;

/**
 * API for handling YANG data types to Swagger models
 * @author cmurch@mrv.com
 * @author bartosz.michalik@amartus.com
 */
public interface DataObjectBuilder extends DataObjectRepo {
    /**
     * Build model for a given node
     * @param node for which model is to be build
     * @param <T> composed type
     * @return model for node
     */
    <T extends SchemaNode & DataNodeContainer> Model build(T node);

    /**
     * Pre-process module
     * @param module to process
     */
    void processModule(Module module);

    /**
     * Typically to build model and store it internally (i.e. in {@link Swagger} models definition
     * @param node
     * @param <T>
     */
    <T extends SchemaNode & DataNodeContainer> void addModel(T node);
}