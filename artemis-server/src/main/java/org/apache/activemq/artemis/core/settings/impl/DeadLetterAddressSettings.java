package org.apache.activemq.artemis.core.settings.impl;

import org.apache.activemq.artemis.api.core.RoutingType;
import org.apache.activemq.artemis.api.core.SimpleString;
import org.apache.activemq.artemis.core.settings.Mergeable;
import org.apache.activemq.artemis.utils.JsonLoader;

import javax.json.JsonObjectBuilder;
import java.io.Serializable;

public class DeadLetterAddressSettings implements Mergeable<DeadLetterAddressSettings>, Serializable {

   private SimpleString prefix = null;

   private RoutingType routingType = null;

   private Boolean durable = null;

   private Boolean temporary = null;

   public DeadLetterAddressSettings() {
   }

   public DeadLetterAddressSettings(SimpleString prefix) {
      this.prefix = prefix;
   }

   public DeadLetterAddressSettings(DeadLetterAddressSettings other) {
      this.prefix = other.prefix;
      this.routingType = other.routingType;
      this.durable = other.durable;
      this.temporary = other.temporary;
   }

   public SimpleString getPrefix() {
      return prefix;
   }

   public DeadLetterAddressSettings setPrefix(SimpleString prefix) {
      this.prefix = prefix;
      return this;
   }

   public RoutingType getRoutingType() {
      return routingType;
   }

   public DeadLetterAddressSettings setRoutingType(RoutingType routingType) {
      this.routingType = routingType;
      return this;
   }

   public Boolean getDurable() {
      return durable;
   }

   public DeadLetterAddressSettings setDurable(Boolean durable) {
      this.durable = durable;
      return this;
   }

   public Boolean getTemporary() {
      return temporary;
   }

   public DeadLetterAddressSettings setTemporary(Boolean temporary) {
      this.temporary = temporary;
      return this;
   }

   @Override
   public void merge(DeadLetterAddressSettings merged) {
      if (prefix == null) {
         prefix = merged.prefix;
      }
      if (routingType == null) {
         routingType = merged.routingType;
      }
      if (durable == null) {
         durable = merged.durable;
      }
      if (temporary == null) {
         temporary = merged.temporary;
      }
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((prefix == null) ? 0 : prefix.hashCode());
      result = prime * result + ((routingType == null) ? 0 : routingType.hashCode());
      result = prime * result + ((durable == null) ? 0 : durable.hashCode());
      result = prime * result + ((temporary == null) ? 0 : temporary.hashCode());

      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;

      DeadLetterAddressSettings other = (DeadLetterAddressSettings) obj;

      if (prefix == null) {
         if (other.prefix != null)
            return false;
      } else if (!prefix.equals(other.prefix))
         return false;
      if (routingType == null) {
         if (other.routingType != null)
            return false;
      } else if (!routingType.equals(other.routingType))
         return false;
      if (durable == null) {
         if (other.durable != null)
            return false;
      } else if (!durable.equals(other.durable))
         return false;
      if (temporary == null) {
         if (other.temporary != null)
            return false;
      } else if (!temporary.equals(other.temporary))
         return false;

      return true;
   }

   @Override
   public String toString() {
      return "DeadLetterAddressSettings [prefix=" + prefix + ", routingType=" + routingType + ", durable=" + durable + ", temporary=" + temporary + "]";
   }

   public JsonObjectBuilder asJSON() {
      JsonObjectBuilder settings = JsonLoader.createObjectBuilder();

      settings.add("prefix", prefix.toString());
      settings.add("routingType", routingType.getType());
      settings.add("durable", durable);
      settings.add("temporary", temporary);

      return settings;
   }
}
