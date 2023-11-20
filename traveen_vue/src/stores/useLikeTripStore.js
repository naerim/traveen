import { ref } from "vue";
import { defineStore } from "pinia";

export const useLikeTripStore = defineStore("tripLike", () => {
  const tripLike = ref({
    idx: "",
    tripinfoIdx: "",
    userId: "",
    createDate: "",
  });

  const liketripList = ref([]);

  const changeLikeTripList = () => {
    liketripList.value = tripLike.value.filter((item) => item.tripinfoIdx);
    console.log(liketripList);
  };

  return { liketripList, changeLikeTripList };
});
