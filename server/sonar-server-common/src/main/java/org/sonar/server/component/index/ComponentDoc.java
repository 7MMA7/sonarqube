/*
 * SonarQube
 * Copyright (C) 2009-2025 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.server.component.index;

import java.util.HashMap;
import java.util.Map;
import org.sonar.server.es.BaseDoc;
import org.sonar.server.permission.index.AuthorizationDoc;

import static org.sonar.server.component.index.ComponentIndexDefinition.FIELD_KEY;
import static org.sonar.server.component.index.ComponentIndexDefinition.FIELD_NAME;
import static org.sonar.server.component.index.ComponentIndexDefinition.FIELD_QUALIFIER;
import static org.sonar.server.component.index.ComponentIndexDefinition.FIELD_UUID;
import static org.sonar.server.component.index.ComponentIndexDefinition.TYPE_COMPONENT;

public class ComponentDoc extends BaseDoc {

  public ComponentDoc() {
    super(TYPE_COMPONENT, new HashMap<>(6));
  }

  /**
   * Needed for reflection. Do not remove.
   */
  public ComponentDoc(Map<String, Object> fields) {
    super(TYPE_COMPONENT, fields);
  }

  @Override
  public String getId() {
    return getField(FIELD_UUID);
  }

  public ComponentDoc setId(String s) {
    setField(FIELD_UUID, s);
    setParent(AuthorizationDoc.idOf(s));
    return this;
  }

  public String getKey() {
    return getField(FIELD_KEY);
  }

  public ComponentDoc setKey(String s) {
    setField(FIELD_KEY, s);
    return this;
  }

  public String getName() {
    return getField(FIELD_NAME);
  }

  public ComponentDoc setName(String s) {
    setField(FIELD_NAME, s);
    return this;
  }

  public String getQualifier() {
    return getField(FIELD_QUALIFIER);
  }

  public ComponentDoc setQualifier(String s) {
    setField(FIELD_QUALIFIER, s);
    return this;
  }

  public ComponentDoc setAuthUuid(String s) {
    setParent(AuthorizationDoc.idOf(s));
    return this;
  }
}
