<template>
    <button @click="changeGiveLike()">  {{ isGiveLike? "顶" : "踩" }} </button>
</template>

<script>
var data = {
    isGiveLike: false
}

export default {
  name: "HelloWorld",
  mounted: function() {
    this.$http.get(`http://localhost:8080/123`).then(
      response => {
        let result = response.data;
        if (result.code == 200) {
            console.log(result.data.isGiveLike);
            data.isGiveLike = result.data.isGiveLike;
        }else{
            alert(result.msg);
        }
      },
      response => {
        console.log("error");
      }
    );
  },
  data() {
    return data;
  },
  methods: {
    changeGiveLike: function(event) {
        let that = this;
        this.$http.post(
                `http://localhost:8080/123`,
                {"isGiveLike": that.$data.isGiveLike},
                {emulateJSON:true}
            )
            .then(
                response => {
                    let result = response.data;
                    console.log(result);
                    if (result.code == 200 && result.data != null) {
                        that.$data.isGiveLike = !result.data.isGiveLike;
                    } else {
                        alert(result.msg);
                    }
                    console.log(that.$data.isGiveLike);
                },
                response => {
                    console.log("error");
                }
            );
    }
  }
}

</script>
