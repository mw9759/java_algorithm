List<List<String>> filteredData = logs.stream()
                    .filter(list -> list.contains("CRITICAL") || list.contains("ERROR"))
                    .collect(Collectors.toList());
        // 정렬
        Collections.sort(filteredData, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> list1, List<String> list2) {
                String dateAndTime1 = list1.get(0) + " " + list1.get(1);
                String dateAndTime2 = list2.get(0) + " " + list2.get(1);
                LocalDateTime dateTime1 = parseDateTime(dateAndTime1);
                LocalDateTime dateTime2 = parseDateTime(dateAndTime2);
                return dateTime1.compareTo(dateTime2);
            }
            
            private LocalDateTime parseDateTime(String dateAndTime) {
                String[] parts = dateAndTime.split(" ");
                String[] dateParts = parts[0].split("-");
                String[] timeParts = parts[1].split(":");
                int year = Integer.parseInt(dateParts[2]);
                int month = Integer.parseInt(dateParts[0]);
                int day = Integer.parseInt(dateParts[1]);
                int hour = Integer.parseInt(timeParts[0]);
                int minute = Integer.parseInt(timeParts[1]);
                return LocalDateTime.of(year, month, day, hour, minute);
            }
        });
        return filteredData;