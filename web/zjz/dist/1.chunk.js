webpackJsonp([1],{

/***/ 22:
/***/ (function(module, exports, __webpack_require__) {


/* styles */
__webpack_require__(30)

var Component = __webpack_require__(5)(
  /* script */
  __webpack_require__(26),
  /* template */
  __webpack_require__(33),
  /* scopeId */
  "data-v-875fa40c",
  /* cssModules */
  null
)
Component.options.__file = "D:\\workspace\\zfzgb\\web\\zjz\\src\\views\\login.vue"
if (Component.esModule && Object.keys(Component.esModule).some(function (key) {return key !== "default" && key !== "__esModule"})) {console.error("named exports are not supported in *.vue files.")}
if (Component.options.functional) {console.error("[vue-loader] login.vue: functional components are not supported with templates, they should use render functions.")}

/* hot reload */
if (false) {(function () {
  var hotAPI = require("vue-loader/node_modules/vue-hot-reload-api")
  hotAPI.install(require("vue"), false)
  if (!hotAPI.compatible) return
  module.hot.accept()
  if (!module.hot.data) {
    hotAPI.createRecord("data-v-875fa40c", Component.options)
  } else {
    hotAPI.reload("data-v-875fa40c", Component.options)
  }
})()}

module.exports = Component.exports


/***/ }),

/***/ 24:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__.p + "d3e0e6774b104f268cba7d3c405c75b5.png";

/***/ }),

/***/ 26:
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//

/* harmony default export */ __webpack_exports__["default"] = ({
    methods: {
        handleStart: function handleStart() {
            this.$Modal.info({
                title: '登录表单',
                content: '输入用户名和密码'
            });
        }
    }
});

/***/ }),

/***/ 30:
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ }),

/***/ 33:
/***/ (function(module, exports, __webpack_require__) {

module.exports={render:function (){var _vm=this;var _h=_vm.$createElement;var _c=_vm._self._c||_h;
  return _c('div', {
    staticClass: "index"
  }, [_c('Row', {
    attrs: {
      "type": "flex",
      "justify": "center",
      "align": "middle"
    }
  }, [_c('Col', {
    attrs: {
      "span": "24"
    }
  }, [_c('h1', [_c('img', {
    attrs: {
      "src": __webpack_require__(24)
    }
  })]), _vm._v(" "), _c('h2', [_c('p', [_vm._v("登录页面!")]), _vm._v(" "), _c('Button', {
    on: {
      "click": _vm.handleStart
    }
  }, [_vm._v("去登录")])], 1)])], 1)], 1)
},staticRenderFns: []}
module.exports.render._withStripped = true
if (false) {
  module.hot.accept()
  if (module.hot.data) {
     require("vue-loader/node_modules/vue-hot-reload-api").rerender("data-v-875fa40c", module.exports)
  }
}

/***/ })

});
//# sourceMappingURL=1.chunk.js.map