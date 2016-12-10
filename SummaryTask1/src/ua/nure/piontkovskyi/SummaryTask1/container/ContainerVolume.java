package ua.nure.piontkovskyi.SummaryTask1.container;

/**
 *
 */
public enum ContainerVolume {

    SMALL(5), MEDIUM(7), LARGE(10);

    private Integer volume;

    /**
     *
     */
    ContainerVolume(Integer volume) {
        this.volume = volume;
    }

    /**
     *
     */
    public Integer getVolume() {
        return volume;
    }
}
