package com.wangkaiyi.web.controller;

import com.wangkaiyi.model.Goods;
import com.wangkaiyi.model.User;
import com.wangkaiyi.model.vo.BuyGoods;
import com.wangkaiyi.service.GoodsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/goods")
@Controller
public class GoodsController {
    @Autowired
    private GoodsServiceImpl goodsService;

    @PostMapping("/insert")
    public ResponseEntity<Void> goodsinsert(
            @RequestParam(value = "price", required = false) Long price,
            @RequestParam(value = "Name", required = false) String name,
            @RequestParam(value = "desc", required = false) String desc,
            @RequestParam(value = "cid", required = false) Long cid,
            @RequestParam(value = "path", required = false) String path,
            @RequestParam(value = "stock", required = false) Long stock) {
        goodsService.insert(price,name,desc, cid,path,stock);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PostMapping("/query")
    public ResponseEntity<Goods> queryAllBypId(
            @RequestParam(value = "pid", required = true) Long pid
    ) {
        return ResponseEntity.ok(goodsService.queryAllBypId(pid));
    }
    @GetMapping("/query/{id}")
    public ResponseEntity<Goods> queryById(@PathVariable("id") Long pid) {
        return ResponseEntity.ok(goodsService.queryAllBypId(pid));
    }

    @PostMapping("/queryAll")
    public ResponseEntity<List<Goods>> queryAll() {
        return ResponseEntity.ok(goodsService.queryAll());
    }

    @PostMapping("/update")
    public ResponseEntity<Void> updateById(
            @RequestParam(value = "pid", required = true) Long pid,
            @RequestParam(value = "price", required = false) Long price,
            @RequestParam(value = "Name", required = false) String name,
            @RequestParam(value = "desc", required = false) String desc,
            @RequestParam(value = "cid", required = false) Long cid,
            @RequestParam(value = "path", required = false) String path,
            @RequestParam(value = "stock", required = false) Long stock
    ) {
        goodsService.updateById(pid, price, name, desc, cid, path, stock);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/delete")
    public ResponseEntity<Void> deleteById(@RequestParam(value = "pid", required = true) Long pid) {
        goodsService.deleteById(pid);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping("/queryByGoodsName")
    @ResponseBody
    public List<Goods> queryByGoodsName(
            @RequestParam(value = "name", required = true) String name) {
        List<Goods> list = goodsService.searchByName(name);
        return list;
    }

    /* @PostMapping("/goods_search_name")
     public ModelAndView goods_search_name(String goods_search_name, Model model){
         model.addAttribute("goods_search_name", goods_search_name);
         return new ModelAndView("shop/home/search","goods_search_name",model);
     }*/
    @RequestMapping(value = "/goods_search_name", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<Void> goods_search_name(HttpServletRequest request) {
        String goods_search_name = request.getParameter("goods_search_name");
        request.getSession().setAttribute("goods_search_name", goods_search_name);
        System.out.println("名字" + goods_search_name);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @RequestMapping(value = "/getGoodsSearchName", method = RequestMethod.POST)
    @ResponseBody
    public String getGoodsSearchName(HttpServletRequest request) {
        String goods_search_name = (String) request.getSession().getAttribute("goods_search_name");
        System.out.println("名字" + goods_search_name);
        return goods_search_name;
    }

    @PostMapping("/saveBuyGoods")
    public ResponseEntity saveBuyGoods(HttpServletRequest request) {
        String BuyGoodspid = request.getParameter("pid");
        String totalprice = request.getParameter("totalprice");
        String goodscount = request.getParameter("goodscount");

        System.out.println("接收到pid" + BuyGoodspid);
        request.getSession().setAttribute("BuyGoodspid", BuyGoodspid);
        request.getSession().setAttribute("totalprice", totalprice);
        request.getSession().setAttribute("goodscount", goodscount);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(value = "/getBuyGoods", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<BuyGoods> getBuyGoodspid(HttpServletRequest request) {
        String BuyGoodspid = (String) request.getSession().getAttribute("BuyGoodspid");
        String totalprice = (String) request.getSession().getAttribute("totalprice");
        String goodscount = (String) request.getSession().getAttribute("goodscount");
        BuyGoods buyGoods = new BuyGoods(BuyGoodspid, totalprice, goodscount);
        return ResponseEntity.ok(buyGoods);

    }

  /*  @PostMapping("/test")
    public String getBuyGoodspid(
            @RequestParam(value = "name", required = true) String name,
            Model model) {Long user_id,Long[] userId, RedirectAttributesModelMap modelMap
        model.addAttribute("name", name);
        return "pay";
    }
*/


    @PostMapping("savegoodsserachId")
    public ResponseEntity<Void> savegoodsserachId(HttpServletRequest request) {
        String goodsserachId = request.getParameter("goodsserachId");
        request.getSession().setAttribute("goodsserachId", goodsserachId);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @PostMapping("getgoodsserachId")
    @ResponseBody
    public String getgoodsserachId(HttpServletRequest request) {
        String goodsserachId=(String) request.getSession().getAttribute("goodsserachId");
        return goodsserachId;
    }
}
