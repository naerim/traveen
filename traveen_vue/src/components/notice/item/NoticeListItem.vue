<script setup>
defineProps({
  notice: Object,
  index: Number,
});
</script>

<template>
  <tr>
    <td>{{ index }}</td>
    <td class="subject">
      <router-link :to="{ name: 'notice-detail', params: { idx: notice.idx } }">{{
        notice.title
      }}</router-link>
    </td>
    <td>{{ notice.createDate }}</td>
    <td>{{ notice.viewCount }}</td>
  </tr>
</template>

<style scoped>
@import "@/assets/scss/components/notice/item/noticeListItem.scss";
</style>
