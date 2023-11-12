<script setup>
import { computed } from "vue";

const props = defineProps({ currentPage: Number, totalPage: Number });
const emit = defineEmits(["pageChange"]);

const navigationSize = parseInt(import.meta.env.VITE_NOTICE_NAVIGATION_SIZE);

const startPage = computed(() => {
  return parseInt((props.currentPage - 1) / navigationSize) * navigationSize + 1;
});

const endPage = computed(() => {
  let lastPage =
    parseInt((props.currentPage - 1) / navigationSize) * navigationSize + navigationSize;
  return props.totalPage < lastPage ? props.totalPage : lastPage;
});

const endRange = computed(() => {
  return parseInt((props.totalPage - 1) / navigationSize) * navigationSize < props.currentPage;
});

function range(start, end) {
  const list = [];
  for (let i = start; i <= end; i++) list.push(i);
  return list;
}

function onPageChange(pg) {
  emit("pageChange", pg);
}
</script>

<template>
  <div class="row">
    <ul class="pagination-container justify-content-center">
      <li class="page-item btn-li">
        <a class="page-link" @click="onPageChange(1)">최신</a>
      </li>
      <li class="page-item btn-li">
        <a class="page-link" @click="onPageChange(startPage == 1 ? 1 : startPage - 1)">이전</a>
      </li>
      <template v-for="pg in range(startPage, endPage)" :key="pg">
        <li
          :class="currentPage === pg ? 'page-item active' : 'page-item'"
          @click="onPageChange(pg)"
        >
          <a class="page-link">{{ pg }}</a>
        </li>
      </template>
      <li class="page-item btn-li">
        <a class="page-link" @click="onPageChange(endRange ? totalPage : endPage + 1)">다음</a>
      </li>
      <li class="page-item btn-li">
        <a class="page-link" @click="onPageChange(totalPage)">끝</a>
      </li>
    </ul>
  </div>
</template>

<style scoped>
a {
  cursor: pointer;
}

.row {
  display: flex;
  flex-direction: column;
}

.pagination-container {
  display: flex;
  align-items: center;
  justify-content: center;
  margin-top: 40px;
}

ul {
  display: flex;
  align-items: center;
  list-style: none;
}

.page-item {
  cursor: pointer;
  margin-right: 20px;
  width: 40px;
  height: 40px;
  border-radius: 50%;
  text-align: center;
  line-height: 40px;
}

.page-item a {
  color: #000;
}

.page-item.active {
  background-color: #51cd89;
}

.page-item.active a {
  color: #fff;
}

.page-item.btn-li .page-link {
  width: 40px;
  height: 30px;
}

.page-item:last-child .page-link a {
  padding-right: 10px; /* 오른쪽 여백을 늘립니다. */
}

.pagination-container .divider {
  height: 20px;
  width: 1px;
  background-color: #d3d3d3;
  margin: 0 20px;
}
</style>
