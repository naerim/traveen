import { ref } from "vue";
import { defineStore } from "pinia";

export const useTripStore = defineStore("trip", () => {
  const selectTrip = ref({});

  const setTrip = (trip) => {
    selectTrip.value = trip;
  };

  return { setTrip, selectTrip };
});
