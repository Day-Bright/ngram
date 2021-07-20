def create_ngram_list(input_list, ngram_num):
    ngram_list = []
    if len(input_list) <= ngram_num:
        ngram_list.append(input_list)
    else:
        num_ = [input_list[i:] for i in range(ngram_num)]
        # print(num_)
        for tmp in zip(*[input_list[i:] for i in range(ngram_num)]):
            # print(tmp)
            tmp = "".join(tmp)
            # print(tmp)
            ngram_list.append(tmp)
    return ngram_list


print(create_ngram_list("123456789", 3))


# 输出['123', '234', '345', '456', '567', '678', '789']


