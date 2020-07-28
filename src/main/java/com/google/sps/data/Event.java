// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.data;

import java.util.HashMap;
import java.util.Date;
import java.util.ArrayList;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EmbeddedEntity;
import com.google.sps.data.Contact;
import com.google.sps.data.Address;

public class Event {

  // Represents ID of Event; Type is long because Datastore's Key's getId() return type is long.
  private long id;
  // Represents the title of the Event.
  private String title;
  // Holds IDs (type long) of Organizations that own the Event.
  private ArrayList<Long> ownerOrgIds;
  // Holds EmbeddedEntity that represents an Organization's ID OR name. A partnering organization could have missing ID.
  private ArrayList<EmbeddedEntity> partnerIdsOrNames;
  // Represents description of the Event. e.g. "In front of church ABC"
  private String description;
  // Holds dates of Event and their corresponding time(s).
  private HashMap<Date, EmbeddedEntity> dateAndHours;
  // Represents when Event was created. Type is long because java.time.Instant returns a long type.
  private long creationTimeStampMillis;
  // Represents when Event was last updated.
  private long lastEditedTimeStampMillis;

  /* Holds contact information for this Event. */

  // Example: help@givr.com
  private String contactEmail;
  // Example: 3923421930 (Assume +1 is prepended)
  private String contactPhone;
  // Example: Bob Jones
  private String contactName;


  /* Holds location information for the Event. All addresses used in this application are in the United States. */

  /* Street Address includes street name and house number/apartment/suite/room number (if any)
   * Example: 1600 Amphitheatre Parkway
   */
  private String streetAddress;
  // Example: Mountain View
  private String city;
  // Example: CA/California
  private String state;
  /* Represents five digit zipcode.
   * Example: 94043
   */
  private String zipcode;

  /* An Event object takes in an entity and assigns all of its fields based on the entity's properties. */
  
  public Event(Entity entity) {
    this.id = (long) entity.getKey().getId();
    this.title = (String) entity.getProperty("eventTitle");
    this.ownerOrgIds = (ArrayList) entity.getProperty("eventOwnerOrgIds");
    this.partnerIdsOrNames = (ArrayList) entity.getProperty("eventPartnerIdsOrNames");
    this.description = (String) entity.getProperty("eventDescription");
    this.dateAndHours = (HashMap) entity.getProperty("eventDateAndHours");
    this.contactEmail = (String) entity.getProperty("eventContactEmail");
    this.contactPhone = (String) entity.getProperty("eventContactPhone");
    this.contactName = (String) entity.getProperty("eventContactName");
    this.creationTimeStampMillis = (long) entity.getProperty("eventCreationTimeStampMillis");
    this.lastEditedTimeStampMillis = (long) entity.getProperty("eventLastEditTimeStampMillis");
    this.streetAddress = (String) entity.getProperty("eventStreetAddress");
    this.city = (String) entity.getProperty("eventCity");
    this.state = (String) entity.getProperty("eventState");
    this.zipcode = (String) entity.getProperty("eventZipcode");
  }

}
