/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.exception;

import com.neu.pojo.Article;
import java.util.Comparator;

/**
 *
 * @author root
 */
public class ComparatorImpl implements Comparator<Article> {

        public ComparatorImpl() {
        }

        public int compare(Article a1, Article a2) {
            return (int) (a2.getArticleId() - a1.getArticleId());
        }
    }