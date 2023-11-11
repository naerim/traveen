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
tr {
  height: 58px;
  border-radius: 6px;
  align-items: center;
  text-align: center;
}

.subject {
  text-align: left;
  padding-left: 80px;
  cursor: pointer;
}

a {
  color: #000;
}

.subject:hover {
  text-decoration: underline;
}
</style>
