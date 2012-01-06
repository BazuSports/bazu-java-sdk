## Resource Usage

    Client c = new RestClient("aksdfaiwenfacnvhsdf");

    Entry e = new Entry.builder().
                withEventId(1234L).
                withRaceId(12345678L).
                build();


    EntityResponse<Entry> response = e.create(c);
    // or
    EntityResponse<Entry> response = client.createResource(e);

    int responseCode = response.getResponseCode(); // HTTP response code
    String responseBody = response.getResponseBody; // Response as a string
    Entry e = response.getEntity(); // Returned entity resource


    // Update entry

    e = Entry.builder(e).
            withFirstName("Ilya").
            build();

    EntityResponse<Entry> response = e.update(c)
    // or
    EntityResponse<Entry> response = client.updateResource(e)

    int responseCode = response.getResponseCode(); // HTTP response code
    String responseBody = response.getResponseBody; // Response as a string
    Entry e = response.getEntity(); // Returned entity resource