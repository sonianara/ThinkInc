package Util;

/**
 * A sorted list of available times during a 24 hour period.
 *
 * @author Kris Campos
 * @version initial version - 1/31/2017.
 */
public class Day {
    TimeNode availability;
    int size;

    /**
     * Enter an additional availability into this day
     *
     * @param availability - TimeInterval representing additional available time slot
     */
    public void add(TimeInterval availability) {
        if(size == 0) {
            this.availability = new TimeNode(availability);
        }
        TimeNode startingNode = getStartPosition(availability);
        insert(availability, startingNode);
        size++;
    }

    /**
     * Helper method to find a TimeNode in the list that corresponds to the given TimeInterval.
     *
     * @param availability - TimeInterval representing availability to find
     * @return TimeNode - A TimeNode in the list whose start time is before or at the same start time as the
     *                      TimeInterval's.
     */
    private TimeNode getStartPosition(TimeInterval availability) {
        TimeNode inList = this.availability;
        while(inList.next != null && inList.timeInterval.getStartTime() <= availability.getStartTime()) {
            inList.next = inList.next.next;
        }
        return inList;
    }

    private void insert(TimeInterval availability, TimeNode inList) {
        if(inList.overlaps(availability)) {
            // set the earlier start time to the node in the list
            double earlierStart = availability.getStartTime() < inList.timeInterval.getStartTime() ?
                    availability.getStartTime() : inList.timeInterval.getStartTime();
            inList.timeInterval.setStartTime(earlierStart);

            // set the later end time to the node in the list
            double laterEnd = availability.getEndTime() < inList.timeInterval.getEndTime() ?
                    availability.getEndTime() : inList.timeInterval.getEndTime();
            inList.timeInterval.setEndTime(laterEnd);

            // collapse any over lapping interval into inList if necessary
            TimeNode temp = inList.next;
            while(temp != null &&  inList.timeInterval.getEndTime() >= temp.timeInterval.getStartTime()) {
                // get later end time...
                laterEnd = temp.timeInterval.getEndTime() > inList.timeInterval.getEndTime() ?
                        temp.timeInterval.getEndTime() : inList.timeInterval.getEndTime();
                // assign that to inList
                inList.timeInterval.setEndTime(laterEnd);
                // update references
                inList.next = temp.next;
                temp = temp.next;
            }
        }
        else {
            TimeNode temp = inList.next;
            inList.next = new TimeNode(availability);
            inList.next.next = temp;
        }
    }

    public void remove(TimeInterval availability) {
        // TODO: Implement...
    }

    private class TimeNode {
        TimeInterval timeInterval;
        TimeNode next;

        TimeNode(TimeInterval timeInterval) {
            this.timeInterval = timeInterval;
        }

        boolean overlaps(TimeNode other) {
            return timeInterval.overlaps(other.timeInterval);
        }

        boolean overlaps(TimeInterval other) {
            return timeInterval.overlaps(other);
        }
    }
}
