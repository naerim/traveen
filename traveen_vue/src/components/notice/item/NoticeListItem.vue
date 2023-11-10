<script setup>
defineProps({
  notice: Object,
});
</script>

<template>
  <tr>
    <td>{{ notice.idx }}</td>
    <td class="subject">
      <router-link :to="{ name: 'notice-detail', params: { idx: notice.idx } }">{{
        notice.title
      }}</router-link>
    </td>
    <td>{{ notice.create_date }}</td>
    <td>{{ notice.view_count }}</td>
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
