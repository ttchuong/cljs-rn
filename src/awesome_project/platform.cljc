(ns awesome-project.platform)

#?(:android
   (defn print-platform []
     (js/console.log "android platform"))
   :ios
   (defn print-platform []
     (js/console.log "ios platform"))
   :cljs ;; default impl
   (defn print-platform []
     (js/console.log "default cljs")))