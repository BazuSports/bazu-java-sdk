## Resource Usage

    Client c = new RestClient("aksdfaiwenfacnvhsdf");

    Entry e = new Entry.builder().
                withEventId(1234L).
                withRaceId(12345678L).
                build();


    e.create(c);

    // or

    client.createResource(e)


    // Update entry

    e = Entry.builder(e).
            withFirstName("Ilya").
            build();
    e.update(c)

    // or

    client.updateResource(e)